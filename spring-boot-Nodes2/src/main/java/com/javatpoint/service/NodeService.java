package com.javatpoint.service;

import java.util.List;
import java.util.Optional;

import com.javatpoint.model.Node;
import com.javatpoint.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NodeService {
    @Autowired
    private NodeRepository nodeRepository;

    public Node createNode(Node node) {
        return nodeRepository.save(node);
    }

    public List<Node> createNodes(List<Node> nodes) {
        return nodeRepository.saveAll(nodes);
    }

    public Node getNodeById(int id) {
        return nodeRepository.findById(id).orElse(null);
    }

    public List<Node> getNodes() {
        return nodeRepository.findAll();
    }

    public Node updateNode(Node node) {
        Node oldNode=null;
        Optional<Node> optionalnode=nodeRepository.findById(node.getId());
        if(optionalnode.isPresent()) {
            oldNode=optionalnode.get();
            oldNode.setWorkflow(node.getWorkflow());
            oldNode.setMainnode(node.getMainnode());
            oldNode.setNodecontent(node.getNodecontent());
            nodeRepository.save(oldNode);

        }else {
            return new Node();
        }
        return oldNode;
    }

    public String deleteNodeById(int id) {
        nodeRepository.deleteById(id);
        return "Node got deleted";
    }

}