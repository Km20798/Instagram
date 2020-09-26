package com.karim.post;

import com.karim.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostServices postServices;

    //public long id ;


    @RequestMapping(value = "/find/{id}")
    public String getPost(Model model, @PathVariable("id") long id) {
        //this.id = id;
        Post post = postServices.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") Post post, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        post.setUser(user);
        postServices.addPost(post);
        return "redirect:/posts/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deletesPost(@PathParam("id") Long id, Model model) {
        postServices.deletePostById(id);
        return "redirect:/posts/";
    }

}