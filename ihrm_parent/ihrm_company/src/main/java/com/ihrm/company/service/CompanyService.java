package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业
     */
    public void add(Company company) {
        //基本属性设置
        String id = idWorker.nextId() + "";

        company.setId(id);
        company.setAuditState("0");
        company.setState(1);
        companyDao.save(company);
    }

    /**
     * 更新企业
     */
    public Company update(Company company) {
        return companyDao.save(company);
    }

    /**
     * 删除企业
     */
    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    /**
     * 根据id查询企业
     */
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    /**
     * 企业列表
     */
    public List<Company> findAll() {
        return companyDao.findAll();
    }

}
