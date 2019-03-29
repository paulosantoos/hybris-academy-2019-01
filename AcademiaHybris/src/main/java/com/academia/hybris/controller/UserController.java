package com.academia.hybris.controller;

import com.academia.hybris.model.User;
import com.academia.hybris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("**/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        User user = null;

        if (id != null && !id.isEmpty()) {
            user = userService.load(Integer.valueOf(id));

            if (user == null) {
                return new ModelAndView("not-found");
            }
        } else {
            user = new User();
        }

        ModelAndView model = new ModelAndView("register-user");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RedirectView save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {

        user = userService.register(user);

        RedirectView rv = new RedirectView();
        rv.setUrl("/user?id=" + user.getId());
        rv.setContextRelative(true);
        return rv;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RedirectView deleteOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) {

        userService.delete(id);

        RedirectView rv = new RedirectView();
        rv.setUrl("/AcademiaHybris_war/users");
        rv.setContextRelative(true);
        return rv;
    }
}
