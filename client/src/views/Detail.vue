<template>
    <div>
        <h3>Repository Detail</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Repo Name</th>
                <th scope="col">User Id</th>
                <th scope="col">Score</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(record, index) in recordList" :key="index">
                <th scope="row">{{index + 1}}</th>
                <td>{{record.repoName}}</td>
                <td>{{record.userId}}</td>
                <td>{{record.score}}</td>
            </tr>
            </tbody>
        </table>
    </div>
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
                $http.get('/rank/' + this.$route.params.id)
                    .then(resp => {
                        this.recordList = resp.data;
                    })
            }
        }
    })


</script>