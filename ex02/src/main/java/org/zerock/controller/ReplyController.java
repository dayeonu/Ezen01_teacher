package org.zerock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* �۾�      URL            HTTP���۹��
 * ��� : /replies/new  :  POST
 * ��ȸ : /replies/:rno    : GET
 * ���� : /replies/:rno   : DELETE
 * ���� : /replies/:rno   : PUT or PATCH
 * ������  : /replies/pages/:bno/:page   : GET
 */
@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
}
