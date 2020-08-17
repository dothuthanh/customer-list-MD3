package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class controller {

    //    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public ModelAndView  showList(Model model) {
        ModelAndView modelAndView = new ModelAndView("list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}