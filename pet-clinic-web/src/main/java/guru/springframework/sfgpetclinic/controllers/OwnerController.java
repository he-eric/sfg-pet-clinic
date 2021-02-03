package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String CREATE_OR_UPDATE_OWNER_VIEW = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @RequestMapping
    public String processFindForms(Owner owner, BindingResult result, Model model) {

        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if (results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            model.addAttribute("selections", results);
            return "owners/ownerList";
        }
    }

    @RequestMapping("/new")
    public String processNewOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return CREATE_OR_UPDATE_OWNER_VIEW;
    }

    @RequestMapping("{ownerId}/edit")
    public String processUpdateOwner(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);
        return CREATE_OR_UPDATE_OWNER_VIEW;
    }

    @PostMapping("/new")
    public String addNewOwner(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors())
            return CREATE_OR_UPDATE_OWNER_VIEW;
        return "redirect:/owners/" + ownerService.save(owner).getId();
    }

    @PostMapping("{ownerId}/edit")
    public String updateExistingOwner(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
        if (result.hasErrors())
            return CREATE_OR_UPDATE_OWNER_VIEW;
        owner.setId(ownerId);
        ownerService.save(owner);
        return "redirect:/owners/" + owner.getId();
    }
}
