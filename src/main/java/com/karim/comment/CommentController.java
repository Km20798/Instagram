package com.karim.comment;

import com.karim.post.PostController;
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

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServices commentServices;

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("comment") Comment comment, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        comment.setUser(user);
        commentServices.addComment(comment);
        // long id  = new PostController().id;
        //System.out.println("the fucker is " + id);
        return "redirect:/profile";
    }
}
