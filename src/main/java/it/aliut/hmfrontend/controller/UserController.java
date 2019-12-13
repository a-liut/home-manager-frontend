package it.aliut.hmfrontend.controller;

import it.aliut.hmfrontend.command.RegisterUserCommand;
import it.aliut.hmfrontend.data.RegisterUserData;
import it.aliut.hmfrontend.entity.User;
import it.aliut.hmfrontend.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * {@link Controller} for exposing information about users.
 */
@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("appTitle", appTitle);

        User[] list = userService.getAll();

        model.addAttribute("users", list);

        return "user/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("appTitle", appTitle);
        model.addAttribute("command", new RegisterUserCommand("", ""));

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(
            @ModelAttribute("command") RegisterUserCommand command,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {
            return "users/register";
        }

        RegisterUserData data = new RegisterUserData(command.getUserName(), command.getUserEmail());

        userService.register(data);

        redirectAttributes.addFlashAttribute("message", "New user successfully created!");

        return "redirect:/";
    }
}
