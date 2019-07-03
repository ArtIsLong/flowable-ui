package com.github.flowable.rest.ext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.flowable.ui.common.service.exception.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 扩展流程图在线设计器(汉化) {@link org.flowable.ui.modeler.rest.app.StencilSetResource}
 * @author 陈敏
 * @version $Id: FlowStencilSetResource.java,v 1.1 2019-06-20 15:02 chenmin Exp $
 * Created on 2019-06-20 15:02
 * My blog： https://www.chenmin.info
 */
@Slf4j
@RestController
@RequestMapping("/app")
public class FlowStencilSetResource {

    @Autowired
    protected ObjectMapper objectMapper;

    /**
     * 汉化流程设计器编辑数据(后续可支持国际化改造)
     * @return
     */
    @RequestMapping(value = "/rest/stencil-sets/editor", method = RequestMethod.GET, produces = "application/json")
    public JsonNode getStencilSetForEditor() {
        try {
            JsonNode stencilNode = objectMapper.readTree(this.getClass().getClassLoader().getResourceAsStream("stencilset/zh/stencilset_bpmn.json"));
            return stencilNode;
        } catch (Exception e) {
            log.error("Error reading bpmn stencil set json", e);
            throw new InternalServerErrorException("Error reading bpmn stencil set json");
        }
    }

    /**
     * 汉化流程设计器编辑数据(后续可支持国际化改造)
     * @return
     */
    @RequestMapping(value = "/rest/stencil-sets/cmmneditor", method = RequestMethod.GET, produces = "application/json")
    public JsonNode getCmmnStencilSetForEditor() {
        try {
            JsonNode stencilNode = objectMapper.readTree(this.getClass().getClassLoader().getResourceAsStream("stencilset/zh/stencilset_cmmn.json"));
            return stencilNode;
        } catch (Exception e) {
            log.error("Error reading bpmn stencil set json", e);
            throw new InternalServerErrorException("Error reading bpmn stencil set json");
        }
    }
}
