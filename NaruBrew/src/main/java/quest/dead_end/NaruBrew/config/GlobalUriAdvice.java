package quest.dead_end.NaruBrew.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalUriAdvice
{
    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model)
    {
        model.addAttribute("currentUri", request.getRequestURI());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal()))
        {
            model.addAttribute("loggedInUsername", auth.getName());
        }
        else
        {
            model.addAttribute("loggedInUsername", null);
        }
    }
}
