import Vue from "vue";
import Router from "vue-router";
import Repos from "./views/Repos.vue";
import Detail from "./views/Detail.vue";
import Retrieve from "./views/Retrieve";
import Score from "./views/Score";
import User from "./views/User";

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
        },
        {
            path:"/user/:id",
            name:"user",
            component: User
        },
        {
            path: "/retrieve",
            name: "retrieve",
            component: Retrieve
        },
        {
            path: "/score",
            name: "score",
            component: Score
        }
    ]
})

export default router;