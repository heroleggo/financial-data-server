import axios from 'axios';

const instance = axios.create({
  baseURL: "https://api.binance.com"
});

export default instance;