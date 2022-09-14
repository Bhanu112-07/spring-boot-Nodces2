package com.javatpoint.controller;

import java.util.List;


import com.javatpoint.model.Node;
import com.javatpoint.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @RequestMapping(value="addnode",method = RequestMethod.POST)
    public Node addNode(@RequestBody Node node) {
        return nodeService.createNode(node);
    }

    @GetMapping("/node/{id}")
    public Node getNodeById(@PathVariable int id) {
        return nodeService.getNodeById(id);
    }

    @GetMapping("/node")
    public List<Node> getAllNodes() {
        return nodeService.getNodes();
    }

    @PutMapping("/updatenode/{id}")
    public Node updateNode(@RequestBody Node node,@PathVariable String id) {
        return nodeService.updateNode(node);
    }

    @DeleteMapping("/node/{id}")
    public String deleteNode(@PathVariable int id) {
        return nodeService.deleteNodeById(id);
    }

}