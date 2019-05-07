<template>
    <div>
        <div class="form-group">
            <label for="repositoryName">Repository Name</label>
            <input type="text" class="form-control" id="repositoryName" v-model="repositoryName"
                   placeholder="Repository Name">
        </div>

        <div class="form-group">
            <label for="repositoryUser">Repository User</label>
            <input type="text" class="form-control" id="repositoryUser" v-model="repositoryUser"
                   placeholder="Repository User">
        </div>

        <button v-on:click="getRepo" class="btn btn-primary">Submit</button>
    </div>
</template>

<script>

    import Vue from "vue";
    import $http from "../http-client";

    export default Vue.extend({
        data() {
            return {
                repositoryName: "",
                repositoryUser: "",
                recordList: []
            };
        },

        /*created: function () {
            this.fetchData();
        },*/

        methods: {
            fetchData: function () {
                $http.get('distinct/repos')
                    .then(resp => {
                        this.recordList = resp.data;
                    })
            },
            getRepo: function () {
                    $http.post('distinct/repos')
                        .then(resp => {
                            this.recordList = resp.data;
                        })
                //console.log("zafer")// `event` is the native DOM event
                /* eslint-disable no-console */
                console.log("zafer");
                /* eslint-enable no-console */
            }
        }
    })
</script>