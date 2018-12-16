package com.library.library.controller;

import com.library.library.model.Account;
import com.library.library.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("accountForm", new Account());

        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("accountForm") Account accountForm, BindingResult bindingResult, Model model) {

        boolean returnRegistration = false;

        if (bindingResult.hasErrors()) {

            returnRegistration = true;
        }


        if (!returnRegistration) {

            Account account = accountService.findByLogin(accountForm.getLogin());

            if (account == null) {
                accountService.save(accountForm);
            } else {
                returnRegistration = true;
                model.addAttribute("error", "User with the same login already exists.");
            }
        }


        return returnRegistration ? "registration" : "redirect:/viewAll";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(Model model, @RequestParam(value = "login") String login, @RequestParam("password") String password) {

        boolean returnLoginPage = false;

        if (login == null || StringUtils.isEmpty(login.trim())) {
            model.addAttribute("error", "Your login or password is invalid.");
            returnLoginPage = true;
        }

        if (password == null || StringUtils.isEmpty(password.trim())) {
            model.addAttribute("error", "Your login or password is invalid.");
            returnLoginPage = true;
        }

        if (!returnLoginPage) {
            Account account = accountService.findByLoginAndPassword(login, password);

            if (account == null) {
                model.addAttribute("error", "It is no user with such login and password");
                returnLoginPage = true;
            }
        }

        return returnLoginPage ? "login" : "redirect:/viewAll";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
}
