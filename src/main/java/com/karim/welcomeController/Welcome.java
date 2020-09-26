package com.karim.welcomeController;

import com.karim.comment.Comment;
import com.karim.comment.CommentServices;
import com.karim.post.Post;
import com.karim.post.PostServices;
import com.karim.user.User;
import com.karim.user.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class Welcome {

    @Autowired
    private PostServices postServices;
    @Autowired
    private CommentServices commentServices;
    @Autowired
    private UserServices userServices;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/signup")
    public String register() {
        return "register";
    }

    @RequestMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "redirect:/";
        List<Post> posts = postServices.getPost();
        model.addAttribute("posts", posts);
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping("/home/{userName}")
    public String home(@PathVariable("userName") String userName, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "redirect:/";
        List<Post> posts = postServices.getPosts(user);
        model.addAttribute("number", posts.size());
        model.addAttribute("user", user);
        return "home";
    }

}