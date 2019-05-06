<template>
    <ol>
        <li v-for="(record, index) in recordList" :key="index">
            <router-link :to="{ name: 'detail', params: { id: record }}">
                {{record}}
            </router-link>
        </li>
    </ol>
</template>

<script>
    import Vue from "vue";
    import $http from "../http-client";

    export default Vue.extend({
        data() {
            return {
                recordList: []
            }
        },

        created: function () {
            this.fetchData();
        },

        methods: {
            fetchData: function () {
                $http.get('distinct/repos')
                    .then(resp => {
                        this.recordList = resp.data;
                    })
            }
        }
    })


</script>