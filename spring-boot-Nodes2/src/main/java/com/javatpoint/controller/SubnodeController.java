package com.javatpoint.controller;

import java.util.List;



import com.javatpoint.model.Subnode;

import com.javatpoint.service.SubnodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubnodeController {
    @Autowired
    private SubnodeService subnodeService;

    @RequestMapping(value="addsubnode",method = RequestMethod.POST)
    public Subnode addSubnode(@RequestBody Subnode subnode) {
        return subnodeService.createSubnode(subnode);
    }

    @GetMapping("/subnode/{id}")
    public Subnode getSubnodeById(@PathVariable int id) {
        return subnodeService.getSubnodeById(id);
    }

    @GetMapping("/subnode")
    public List<Subnode> getAllSubnodes() {
        return subnodeService.getSubnodes();
    }

    @PutMapping("/updatesubnode/{id}")
    public Subnode updateSubnode(@RequestBody Subnode subnode,@PathVariable String id) {
        return subnodeService.updateSubnode(subnode);
    }

    @DeleteMapping("/subnode/{id}")
    public String deleteSubnode(@PathVariable int id) {
        return subnodeService.deleteSubnodeById(id);
    }

}
