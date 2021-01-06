import { API } from 'utils';
import { Alert, Download } from 'quantex-design';

class Store {
  constructor(modal) {
    this.api = new API('cds-web');
    this.modal = modal;
  }

  // 父表格存储
  setTableStore = tableStore => {
    this.tableStore = tableStore;
  };

  // 父表格操作后的刷新方法
  search = () => {
    this.tableStore.reload();
  };

  // 子表格存储
  setChildTableStore = tableStore => {
    this.childTableStore = tableStore;
  };

  // 子表格操作后的刷新方法
  childSearch = (data) => {
    this.childTableStore.api.setRowData(data);
  };

  /**
   * 获取数据字典子项
   * @param id
   * @param cb
   */
  fetchDictItem = (dictId, cb) => {
    this.api
      .query('/sys_dict_data_def', {
        dictId,
        orderBy: 'id',
      })
      .then(res => {
        if (res.code === 200) {
          cb && cb(res.data.list);
        } else {
          Alert.error(res);
        }
      });
  };

  /**
   * 添加数据字典
   * @param formData
   */
  addDict = formData => {
    this.api.post('/sys_dict_data', formData).then(res => {
      if (res.code === 200) {
        Alert.success('添加成功!', close => {
          this.search();
          this.modal.close();
          close();
        });
      } else {
        Alert.error(res);
      }
    });
  };

  /**
   * 编辑字典
   * @param formData
   */
  updateDict = formData => {
    this.api.put('/sys_dict_data/{id}', formData).then(res => {
      if (res.code === 200) {
        Alert.success('编辑成功!', close => {
          this.search();
          this.modal.close();
          close();
        });
      } else {
        Alert.error(res);
      }
    });
  };

  /**
   * 编辑字典子项
   * @param formData 字典子项数据
   * @param id 字典项Id
   */
  updateDictItem = (formData, id) => {   
    this.api.put('/sys_dict_data/defs/{id}', formData).then(res => {
      if (res.code === 200) {
        Alert.success('编辑成功!', close => {
          this.fetchDictItem(id, subDicts => {
            this.childSearch(subDicts);
          });
          this.modal.close();
          close();
        });
      } else {
        Alert.error(res);
      }
    });
  };

  /**
   * 删除一条字典
   * @param id
   */
  deleteDict = id => {
    this.api
      .delete('/sys_dict_data/{id}', { id })
      .then(res => {
        if (res.code === 200) {
          Alert.success('删除成功!', close => {
            this.search();
            close();
          });
        } else {
          Alert.error(res);
        }
      });
  };

  /**
   * 删除字典子项
   * @param dictId 字典Id
   * @param id 字典子项Id
   */
  deleteDictItem = (dictId, id) => {
    this.api
      .delete('/sys_dict_data/defs/{id}', { id })
      .then(res => {
        if (res.code === 200) {
          Alert.success('删除成功!', close => {
            this.fetchDictItem(dictId, subDicts => {
              this.childSearch(subDicts);
            });
            close();
          });
        } else {
          Alert.error(res);
        }
      });
  };

  exportFile = (formData, type) => {
    let params = {
      downloadSite: 'cds-web',
      method: 'GET',
      downloadParams: formData,
      action: `/sys_dict_data/${type}/download`,
    };
    Download.downloadFile(params);
  }
}

export default Store;
