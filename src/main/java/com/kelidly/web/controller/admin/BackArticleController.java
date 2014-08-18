package com.kelidly.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kelidly.entity.Article;
import com.kelidly.entity.ArticleType;
import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.NewsService;

@Controller
@RequestMapping("/back/article")
public class BackArticleController {

	@Resource(name = "articleService")
	ArticleService articleService;
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 类目管理
	 * @param model
	 * @return
	 */
	@RequestMapping("/showArticleType")
	public String showArticleType(Model model){
		
		List<ArticleType> articleTypeList = articleService.findAllArticleType();
		model.addAttribute("articleTypeList", articleTypeList);
		
		return "/admin/article/type_manage";
	}
	
	/**
	 * 修改文章标题
	 * @param response
	 * @param model
	 * @param articleType
	 * @return
	 */
	@RequestMapping("/updateArticleType")
	@ResponseBody
	public String updateArticleType(HttpServletResponse response,Model model,ArticleType articleType){
	
		String result = "";
		boolean flag = articleService.updateArticleType(articleType);
        if (flag) {
			result = "success";
		}        
        //response.setCharacterEncoding("utf-8");
		return "success";
	}
	
	/**
	 * 删除该id文章类型
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/delArticleType")
	public String delArticleType(Model model,@RequestParam("typeId") int id){		
		
		String rtMsg = "";
		boolean flag = articleService.deleteArticleType(id);
        if (flag) {        	
        	rtMsg = "删除成功！";	
		}else{
			rtMsg = "删除失败！请查明原因。";
		}        
        model.addAttribute("rtMsg", rtMsg);
        
        return showArticleType(model);
		
	}
	
	/**
	 * 添加文章类型
	 * @param model
	 * @param articleType
	 * @return
	 */
	@RequestMapping("/addArticleType")		
	public String addType(Model model, ArticleType articleType) {

		String rtMsg = "";
		boolean flag = articleService.addArticleType(articleType);
		if (flag) {
			rtMsg = "添加成功！";
		} else {
			rtMsg = "添加失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		
		return showArticleType(model);
	}
	
//	@RequestMapping("/addArticleView")
//	public String addArticleView(Model model){
//		
//		List<ArticleType> articletypeList = articleService.findAllArticleType();
//		model.addAttribute("articletypeList", articletypeList);
//		return "/admin/article/article_pub";
//	}
	
	/**
	 * 添加文章
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping("/addArticle")
	public String addArticle(Article article,Model model){		
		
		if("add".equals(request.getParameter("status"))){
			
			String rtMsg = "";
			boolean flag = articleService.addArticle(article);
			if (flag) {
				rtMsg = "添加成功！";
				// 返回文章管理
				model.addAttribute("rtMsg", rtMsg);		
				return manageArticle(model);
			} else {
				rtMsg = "添加失败！请查明原因。";
				List<ArticleType> articletypeList = articleService.findAllArticleType();
				model.addAttribute("articletypeList", articletypeList);
				model.addAttribute("rtMsg", rtMsg);	
				return "/admin/article/article_pub";
			}
		}else{
			List<ArticleType> articletypeList = articleService.findAllArticleType();
			model.addAttribute("articletypeList", articletypeList);
			return "/admin/article/article_pub";
		}
		
	}
	
	/**
	 * 管理文章
	 * @param model
	 * @return
	 */
	@RequestMapping("/manageArticle")
	public String manageArticle(Model model){
		
		PageModel pagemodel = articleService.findArticlebypage(1,5);		
		model.addAttribute("pagemodel", pagemodel);
		
		List<ArticleType> articleTypeList = articleService.findAllArticleType();
		model.addAttribute("articleTypeList", articleTypeList);
		
		return "/admin/article/article_manage";
	}
	
	/**
	 * 删除该id文章
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/delArticle")
	public String delArticle(Model model,@RequestParam("id") int id){		
		
		String rtMsg = "";
		boolean flag = articleService.deleteArticle(id);
        if (flag) {        	
        	rtMsg = "删除成功！";	
		}else{
			rtMsg = "删除失败！请查明原因。";
		}        
        model.addAttribute("rtMsg", rtMsg);
        
        return manageArticle(model);
		
	}
	
	/**
	 * 编辑文章
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateArticle")
	public String updateArticle(@RequestParam("id")int id,Model model){
		
		Article article = articleService.findArticleByid(id);
		model.addAttribute("article", article);

		List<ArticleType> articleTypeList = articleService.findAllArticleType();
		model.addAttribute("articleTypeList", articleTypeList);

		return "/admin/article/article_update";
		
	}
	
	@RequestMapping("/doupdateArticle")
	public String updateArticle(Article article,Model model){
		
		String rtMsg = "";
		boolean flag = articleService.updateArticle(article);
		if (flag) {
			rtMsg = "修改成功！";
		} else {
			rtMsg = "修改失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		return manageArticle(model);
	}
	
	@RequestMapping("/pageQuery")
	public String toPageManage(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,Model model){
	
		
		PageModel pagemodel = articleService.findArticleByPage(pageNo,pageSize);		
		model.addAttribute("pagemodel", pagemodel);
		
		List<ArticleType> articleTypeList = articleService.findAllArticleType();
		model.addAttribute("articleTypeList", articleTypeList);
		
		return "/admin/article/article_manage";
	}	
	
}
