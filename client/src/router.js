import Vue from "vue";
import Router from "vue-router";
import Repos from "./views/Repos.vue";
import Detail from "./views/Detail.vue";


Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: "/",
            name: "repos",
            component: Repos
        },
        {
            path: "/detail/:id",
            name: "detail",
            component: Detail
        }
    ]
})

export default router;