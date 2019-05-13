import axios from "axios";

const $http = axios.create({
    baseURL: "http://localhost:8040/api/",
    timeout: 1000
});

export default $http;