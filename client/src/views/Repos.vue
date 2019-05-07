<template>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Repo Name</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(record, index) in recordList" :key="index">
            <th scope="row">{{index + 1}}</th>
            <td>
                <router-link :to="{ name: 'detail', params: { id: record }}">
                    {{record}}
                </router-link>
            </td>
        </tr>
        </tbody>
    </table>
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