import { API } from '@gza/quantex-utils';
import { SERVER_NAME } from '../pages/system/common/CONSTANTS';

class Store {
  api = new API(SERVER_NAME);
  getSystemDate = async() => {
    const res = await this.api.get('/api/v1/date');
    console.log('res', res);
    if (res.code === 200) {
      return res.data;
    }
  }
}
export default Store;
