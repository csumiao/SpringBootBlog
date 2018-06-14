package com.miao.blog.service;

import com.miao.blog.dao.TypeRepository;
import com.miao.blog.entity.Type;
import com.miao.blog.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRespository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRespository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRespository.findOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRespository.findAll(pageable);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRespository.findOne(id);
        if (t==null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRespository.save(t);
    }

    @Override
    public List<Type> listType() {
        return typeRespository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Direction.DESC, "blogs.size");
        Pageable pageable = new PageRequest(0, size, sort);
        return typeRespository.findTop(pageable);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRespository.findByName(name);
    }

    @Override
    public void deleteType(Long id) {
        typeRespository.delete(id);
    }
}
