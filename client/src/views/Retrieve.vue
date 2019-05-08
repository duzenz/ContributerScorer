<template>
    <div>
        <h3>Retrieve Repository</h3>
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

        methods: {
            getRepo: function () {
                if (this.repositoryName === "" || this.repositoryUser === "") {
                    alert("Values can not be null");
                } else {
                    const url = '/repo/' + this.repositoryUser + '/' + this.repositoryName;
                    $http.post(url)
                        .then(resp => {
                            alert("Retrieve repository is ok");
                            this.repositoryUser = "";
                            this.repositoryName = "";
                        }).catch((err) => {
                        alert("Retrieve repository is ok");
                        this.repositoryUser = "";
                        this.repositoryName = "";
                    });
                }
            }
        }
    })
</script>