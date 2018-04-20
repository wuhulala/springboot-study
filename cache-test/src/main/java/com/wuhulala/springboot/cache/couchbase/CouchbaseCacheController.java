package com.wuhulala.springboot.cache.couchbase;

import com.wuhulala.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 功能说明: com.wuhulala.springboot.cache<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/20<br>
 */
@RestController
@RequestMapping("/product")
public class CouchbaseCacheController {
    @Autowired
    private CouchbaseTemplate couchbaseTemplate;

    @PostMapping
    public String save(@RequestBody Product product) {
        couchbaseTemplate.save(product);
        return "success";
    }

    /**
     * 缓存获取
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Cacheable(value = {"product", "default"}, key = "#id")
    public Product get(@PathVariable String id) {
        return couchbaseTemplate.findById(id, Product.class);
    }

    /**
     * 缓存更新
     * @param product
     * @return
     */
    @PutMapping("/{id}")
    @CachePut(value = {"default", "product"}, key = "#product.id")
    public Product put(@RequestBody Product product){
        couchbaseTemplate.save(product);
        return product;
    }

    /**
     * 缓存删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @CacheEvict(value = {"default", "product"}, key = "#id")
    public void delete(@PathVariable String id) {
        couchbaseTemplate.remove(couchbaseTemplate.findById(id, Product.class));
    }


}
