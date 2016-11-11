 

package com.noahedu.noahmvpdemo.model.entities;

import com.lidroid.xutils.db.annotation.NoAutoIncrement;

 
public abstract class EntityBase {
	
//  @Id // �������û��������Ϊid��_id��ʱ����ҪΪ������Ӵ�ע��
  @NoAutoIncrement // int,long���͵�idĬ������������ʹ������ʱ��Ӵ�ע��
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
