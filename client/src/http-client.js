import axios from "axios";

const $http = axios.create({
    baseURL: "http://192.168.99.100:8040/api/",
    timeout: 5000
});

export default $http;