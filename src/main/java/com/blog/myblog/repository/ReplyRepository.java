package com.blog.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
