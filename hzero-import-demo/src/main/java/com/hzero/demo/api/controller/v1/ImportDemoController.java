package com.hzero.demo.api.controller.v1;

import com.hzero.demo.domain.entity.ImportDemo;
import com.hzero.demo.domain.repository.ImportDemoRepository;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/v1/demo/import")
public class ImportDemoController extends BaseController {

    @Autowired
    private ImportDemoRepository importDemoRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<ImportDemo>> list(ImportDemo importDemo, @ApiIgnore @SortDefault(value = ImportDemo.FIELD_USERNAME,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ImportDemo> list = importDemoRepository.pageAndSort(pageRequest, importDemo);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{username}")
    public ResponseEntity<ImportDemo> detail(@PathVariable Long username) {
        ImportDemo importDemo = importDemoRepository.selectByPrimaryKey(username);
        return Results.success(importDemo);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<ImportDemo> create(@RequestBody ImportDemo importDemo) {
        validObject(importDemo);
        importDemoRepository.insertSelective(importDemo);
        return Results.success(importDemo);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<ImportDemo> update(@RequestBody ImportDemo importDemo) {
        SecurityTokenHelper.validToken(importDemo);
        importDemoRepository.updateByPrimaryKeySelective(importDemo);
        return Results.success(importDemo);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ImportDemo importDemo) {
        SecurityTokenHelper.validToken(importDemo);
        importDemoRepository.deleteByPrimaryKey(importDemo);
        return Results.success();
    }

}
