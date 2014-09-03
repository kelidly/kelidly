package com.kelidly.web.controller.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kelidly.constants.Global;
import com.kelidly.entity.Article;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.SiteService;
import com.kelidly.util.DateUtil;
import com.kelidly.web.controller.BaseController;

@Controller
@RequestMapping("/back/article")
public class BackArticleController extends BaseController {

	@Resource(name = "articleService")
	ArticleService articleService;

	@Resource(name = "siteService")
	SiteService siteService;

	@Autowired
	private HttpServletRequest request;

	

	/**
	 * 添加文章
	 * 
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping("/addArticle")
	public String addArticle(
			Article article,
			Model model,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "imgfile", required = false) CommonsMultipartFile imgfile) {

		if ("add".equals(status)) {

			if(imgfile!=null){
				// 添加图片
				String filePath = addImage(imgfile);
				if (filePath != null) {
					article.setImgurl(filePath);
				} else {
					article.setImgurl(null);
				}
			}



			article.setAddtime(new Date());
			String rtMsg = "";
			boolean flag = articleService.addArticle(article);
			if (flag) {
				rtMsg = "添加成功！";
				// 返回文章管理
				model.addAttribute("rtMsg", rtMsg);
				return manageArticle(1, 10, model);
			} else {
				rtMsg = "添加失败！请查明原因。";
				List<Site> secListSiteList = siteService
						.findSecondListSiteList();
				model.addAttribute("secListSiteList", secListSiteList);
				model.addAttribute("rtMsg", rtMsg);
				return "/admin/article/article_pub";
			}
		} else {
			List<Site> secListSiteList = siteService.findSecondListSiteList();
			model.addAttribute("secListSiteList", secListSiteList);
			return "/admin/article/article_pub";
		}

	}

	/**
	 * 添加文章
	 * 
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSwfFiles", method = RequestMethod.POST)
	@ResponseBody
	public String addSwfFiles(
			@RequestParam(value = "swfdirName", required = false) String filedirName,
			@RequestParam("file") CommonsMultipartFile flashFile) {

		// 系统配置目录
		String varfilename = Global.getValue("resources");
		// 资源目录
		String savePath = varfilename + "/" + filedirName;
		
		return this.addFlashFiles(savePath, flashFile);

	}

	/**
	 * 管理文章
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/manageArticle")
	public String manageArticle(
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			Model model) {

		PageModel pagemodel = articleService
				.findArticleByPage(pageNo, pageSize);
		model.addAttribute("pagemodel", pagemodel);

		List<Site> secondSiteList = siteService.findAllSecondSiteList();
		model.addAttribute("secondSiteList", secondSiteList);

		return "/admin/article/article_manage";
	}

	/**
	 * 删除该id文章
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/delArticle")
	public String delArticle(Model model, @RequestParam("id") int id) {

		String rtMsg = "";
		boolean flag = articleService.deleteArticle(id);
		if (flag) {
			rtMsg = "删除成功！";
		} else {
			rtMsg = "删除失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);

		return manageArticle(1, 10, model);

	}

	/**
	 * 修改文章
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateArticle")
	public String updateArticle(@RequestParam("id") int id, Model model) {

		Article article = articleService.findArticleByid(id);
		model.addAttribute("article", article);

		List<Site> secListSiteList = siteService.findSecondListSiteList();
		model.addAttribute("secListSiteList", secListSiteList);

		return "/admin/article/article_update";

	}

	/**
	 * 修改文章操作
	 * 
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping("/doupdateArticle")
	public String updateArticle(Article article,@RequestParam(value = "imgfile", required = false) CommonsMultipartFile imgfile, Model model) {
		
		if(imgfile!=null){
			// 添加图片
			String filePath = addImage(imgfile);
			if (filePath != null) {
				article.setImgurl(filePath);
			} else {
				article.setImgurl(null);
			}
		}
		
		String rtMsg = "";
		boolean flag = articleService.updateArticle(article);
		if (flag) {
			rtMsg = "修改成功！";
		} else {
			rtMsg = "修改失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		return manageArticle(1, 10, model);
	}

}
