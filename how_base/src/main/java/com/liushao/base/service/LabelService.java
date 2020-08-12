package com.liushao.base.service;

import com.liushao.base.dao.LabelDao;
import com.liushao.base.pojo.Label;
import com.liushao.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存一个标签
     */
    public void saveLabel(Label label){
        //设置ID
        label.setId(idWorker.nextId()+"");
        labelDao.insert(label);
    }
    /**
     * 更新一个标签
     */
    public void updateLabel(Label label){
        labelDao.updateById(label);
    }

    /**
     * 删除一个标签
     */
    public void deleteLabelById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findLabelList() {
        return labelDao.selectList(null);
    }

    /**
     * 根据ID查询标签
     *
     * @return
     */
    public Label findLabelById(String id) {
        return labelDao.selectById(id);
    }

}
