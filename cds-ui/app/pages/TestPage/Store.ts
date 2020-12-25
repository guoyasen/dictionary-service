import { API } from '@gza/quantex-utils';
class Store {
  api = new API('cds-web');

  getUserName = () => {
    return this.api.get('/portal/test');
  };
}

export default Store;
