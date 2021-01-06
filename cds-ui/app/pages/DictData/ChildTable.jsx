import React from 'react';
import { observer } from 'mobx-react';
import { AgGrid, AButtonGroup, Modal, Aa } from 'quantex-design';
import { Popconfirm } from 'antd';
import EditDictItemForm from './form/EditDictItem';
import Store from './Store';

@observer
class ChildTableComponent extends React.Component {
  constructor(props) {
    super(props);

    this.modal = new Modal.Store();
    this.store = new Store(this.modal);

    this.tableConfig = {
      tableId: this.createDetailGridId(),
      // 各列配置
      props: {
        columnDefs: [
          {
            headerName: '字典值',
            field: 'value',
          },
          {
            headerName: '字典值翻译',
            field: 'name',
          },
          {
            headerName: '字典英文值',
            field: 'enName',
          },
          {
            headerName: '操作',
            colId: 'operation',
            filter: false, // 禁用过滤
            sortable: false, // 禁用排序
            cellRendererFramework: ({ data = {} }) => {
              return (
                <AButtonGroup>
                  <Aa
                    onClick={() => {
                      this.showEditDictItemForm(this.props.data, data); // 字典子项数据加上字典项的id
                    }}>编辑</Aa>
                  <Aa 
                    className='text-danger'
                    onClick={() => {
                      this.handleDeleteDictItem(this.props.data, data);
                    }}>删除</Aa>
                </AButtonGroup>
              );
            },
          }
        ],
        rowData: [],
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
      },

      onTableReady: tableStore => {
        this.store.setChildTableStore(tableStore);
        this.handleTableReady(tableStore);
      },
    };

    this.rowIndex = this.props.rowIndex;
    this.masterGridApi = this.props.api;

    this.searchApi = AgGrid.createSearchApi({
      api: 'cds-web',
      url: '/sys_dict_data_def',
      params: {
        dictId: this.props.data.id,
      },
      config: {
        loading: false,
      },
    });
  }

  componentWillUnmount() {
    // 销毁嵌套表格
    const detailGridId = this.createDetailGridId();
    this.masterGridApi.removeDetailGridInfo(detailGridId);
  }

  /**
   * 获取嵌套内容id
   */
  createDetailGridId = () => {
    return 'detail_' + this.rowIndex;
  };

  /**
   * 嵌套表格渲染完成后回调
   */
  handleTableReady = params => {
    const result = this.searchApi.search();
    result.then(data => {
      params.api.setRowData(data.list);
    });
    // 获取嵌套内容id
    const detailGridId = this.createDetailGridId();
    // grid info
    const gridInfo = {
      id: detailGridId,
      api: params.api,
      columnApi: params.columnApi,
    };
    // 在父行中添加子嵌套
    this.masterGridApi.addDetailGridInfo(detailGridId, gridInfo);

  };

  /**
   * 编辑字典子项
   * @param data 字典项数据
   * @param subData 字典子项数据
   */
  showEditDictItemForm = (data, subData) => {
    const bar = (
      <EditDictItemForm dataSource={subData} store={this.store} parentData={data} />
    );
    this.modal.openForm('编辑字典项', bar);
  };

  /**
   * 删除字典子项
   * @param data 字典项数据
   * @param subData 字典子项数据
   */
  handleDeleteDictItem = (data, subData) => {
    this.store.deleteDictItem(data.id, subData.id);
  };

  render() {
    return (
      <div style={{ height: 300, padding: 10 }}>
        <AgGrid.Table tableConfig={this.tableConfig} />
        <Modal {...this.modal.props} />
      </div>
    );
  }
}

export default ChildTableComponent;
