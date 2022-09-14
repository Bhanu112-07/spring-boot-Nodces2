package com.javatpoint.service;

import java.util.List;
import java.util.Optional;


import com.javatpoint.model.Subnode;
import com.javatpoint.repository.SubnodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SubnodeService {
    @Autowired
    private SubnodeRepository subnodeRepository;

    public Subnode createSubnode(Subnode subnode) {
        return subnodeRepository.save(subnode);
    }

    public List<Subnode> createSubnodes(List<Subnode> subnodes) {
        return subnodeRepository.saveAll(subnodes);
    }

    public Subnode getSubnodeById(int id) {
        return subnodeRepository.findById(id).orElse(null);
    }

    public List<Subnode> getSubnodes() {
        return subnodeRepository.findAll();
    }

    public Subnode updateSubnode(Subnode subnode) {
        Subnode oldSubnode=null;
        Optional<Subnode> optionalsubnode=subnodeRepository.findById(subnode.getId());
        if(optionalsubnode.isPresent()) {
            oldSubnode=optionalsubnode.get();
            oldSubnode.setSub(subnode.getSub());
            oldSubnode.setSubcontent(subnode.getSubcontent());
            subnodeRepository.save(oldSubnode);

        }else {
            return new Subnode();
        }
        return oldSubnode;
    }

    public String deleteSubnodeById(int id) {
        subnodeRepository.deleteById(id);
        return "Subnode got deleted";
    }

}