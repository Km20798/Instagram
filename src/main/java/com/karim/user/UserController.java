package com.karim.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    private static String uploadDirectory = "E:\\projects\\Instagram\\src\\main\\resources\\static\\image";

    @RequestMapping(value = {"/login/{email}/{password}"}, method = RequestMethod.POST)
    public String login(@PathParam("email") String email, @PathParam("password") String password,
                        Model model, HttpServletRequest request) {
        User user = userServices.findByEmailAndPassword(email, password);
        if (user == null) {
            return "redirect:/";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/profile";
        }
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUser(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
        User me = userServices.addUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", me);
        model.addAttribute("user", me);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
        userServices.addUser(user);
        return "redirect:/home/" + user.getUserName();
    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "information";
    }

    @RequestMapping("/img")
    public String getImage() {
        return "images";
    }

    @RequestMapping(value = "/editimg", method = RequestMethod.POST)
    public String Upload(Model model, @RequestParam("files") MultipartFile[] files, HttpSession session, HttpServletRequest request) {

        session = request.getSession();
        User user = (User) session.getAttribute("user");
        StringBuilder builder = new StringBuilder();
        for (MultipartFile file : files) {
            Path filenameAndPath = Paths.get(uploadDirectory, user.getUserName() + ".jpg");
            builder.append(file.getOriginalFilename());
            try {
                Files.write(filenameAndPath, file.getBytes());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            model.addAttribute("msg", "done");
        }

        return "redirect:/profile";
    }

}