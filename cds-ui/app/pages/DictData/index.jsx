import React from 'react';
import { observer } from 'mobx-react';
import { AgGrid, AButton, AButtonGroup, Modal, Download, Aa } from 'quantex-design';
import { Button, Popconfirm } from 'antd';
import { DICTDATA } from 'utils';
import ChildTable from './ChildTable';
import BatchDictForm from './form/BatchDict';
import ExportFileForm from './form/ExportFile';
import Store from './Store';
import UIState from './UIState';

@observer
class DictDataComponent extends React.Component {
  uiState = new UIState();
  modal = new Modal.Store();
  store = new Store(this.modal);

  searchApi = AgGrid.createSearchApi({
    api: 'cds-web',
    url: '/sys_dict_data',
  });

  tableConfig = {
    tableId: AgGrid.Table.ID.DictData_index,
    onTableReady: tableStore => {
      this.store.setTableStore(tableStore);
    },
    props: {
      columnDefs: [
        {
          headerName: '字典key',
          field: 'dictKey',
          cellRenderer: 'agGroupCellRenderer',
        },
        {
          headerName: '字典名称',
          field: 'dictName',
        },
        {
          headerName: '字典值类型',
          field: 'dictValueType',
          valueGetter: ({ data }) => {
            let findValue = DICTDATA.cds_dict_value_type.find(item => item.id === data.dictValueType);
            return findValue.name;
          },
        },
        {
          headerName: '所属应用',
          field: 'appId',
          filter: 'agSetColumnFilter',
        },
        {
          headerName: '创建用户',
          field: 'creatorIdName',
        },
        {
          headerName: '创建时间',
          field: 'createTime',
          type: 'datetime'
        },
        {
          headerName: '修改用户',
          field: 'modifierIdName',
        },
        {
          headerName: '修改时间',
          field: 'modifyTime',
          type: 'datetime'
        },
        {
          headerName: '备注',
          field: 'remark',
        },
        {
          headerName: '操作',
          colId: 'operation',
          filter: false, // 禁用过滤
          sortable: false, // 禁用排序
          cellRendererFramework: ({ data = {} }) => {
            return (
              <AButtonGroup>
                <Aa onClick={() => {
                  this.showBatchDictForm(data, 'edit');
                }} >编辑</Aa>
                <Popconfirm title='是否确认删除该字典?'
                  onConfirm={() => {
                    this.handleDeleteDict(data);
                  }}>
                  <Aa className='text-danger'>删除</Aa>
                </Popconfirm>
              </AButtonGroup>
            );
          },
        }
      ],
      // 列默认配置
      defaultColDef: {
        width: 200,
        resizable: true,
        sortable: true,
        floatingFilter: true,
        filter: 'agTextColumnFilter',
        filterParams: {
          caseSensitive: true,
          newRowsAction: 'keep',
        },
      },
      paginationPageSize: 20,
      pagination: true,

      // 子表格
      masterDetail: true,
      detailCellRenderer: 'myDetailCellRenderer',
      frameworkComponents: { myDetailCellRenderer: ChildTable },
      rowData: [],
    },
  };


  // 显示'添加字典'表单
  showBatchAddDictForm = () => {
    this.uiState.setDictItemKeys([{ key: 0 }]); // 默认显示一组
    const bar = <BatchDictForm store={this.store} uiState={this.uiState} type="add" />;
    this.modal.openForm('添加字典', bar);
  };

  /**
   * 批量编辑
   * 1. 判断当前记录是否存在子项数据(dictItem), 若没有则去请求子项数据
   * 2. 初始化子项对应Key值
   * @param data
   * @returns {XML}
   */
  showBatchDictForm = (data) => {
    /**
     * 展开编辑表单
     * @param dataSource 初始化编辑表单的数据
     */
    const showForm = dataSource => {
      const bar = <BatchDictForm dataSource={dataSource} store={this.store}  uiState={this.uiState} type="edit" />;
      this.modal.openForm("编辑字典", bar);
    };
    /**
     * 初始化子项 key
     * @param dictItems 子项数据
     */
    const initDictItemKeys = dictItems => {
      const keys = dictItems.map((item, index) => {
        return {
          key: index,
        };
      });
      this.uiState.setDictItemKeys(keys);
    };

    // 请求字典子项数据
    this.store.fetchDictItem(data.id, subDicts => {
      data.dicts = subDicts;
      // 初始化字典子项对应的key值
      if (subDicts.length) {
        initDictItemKeys(subDicts);
      }
      showForm(data);
    });

  };

  /**
  * 删除字典
  * @param data
  */
  handleDeleteDict = data => {
    this.store.deleteDict(data.id);
  };

  exportFile = () => {
    const bar = <ExportFileForm store={this.store} />;
    this.modal.openForm("导出文件", bar);
  }

  render() {
    return (
      <div className="qx-main">
        <div className="m-b-10">
          <AButton className="m-r-10" type='primary' size='small' onClick={this.showBatchAddDictForm}>新增</AButton>
          <AButton type='primary' size='small' onClick={this.exportFile}>导出</AButton>
        </div>
        <AgGrid.PageTable
          searchApi={this.searchApi}
          tableConfig={this.tableConfig}
          searchOnReady>        
        </AgGrid.PageTable>
        <Modal {...this.modal.props} />
      </div>
    );
  }
}

export default DictDataComponent;
