package com.boo.companydataloader.controller;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.service.OrganizationDataMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class PagesController {
    @Autowired
    private OrganizationDataMineService organizationDataMineService;

    @GetMapping({"/get-index-page", "/"})
    public String getIndexPage() {
        return "index";
    }

    @PostMapping("/search-data-by-inn")
    public String searchDataByInn(
            @RequestParam String inn,
            Map <String, Object> model) {
        model.put("organizationData", organizationDataMineService.search(inn));
        return "dataPage";
    }
}
