<template>
    <div>
        <h3>Score Repository</h3>
        <div class="form-group">
            <label for="repositoryName">Repository Name</label>
            <input type="text" class="form-control" id="repositoryName" v-model="repositoryName"
                   placeholder="Repository Name">
        </div>
        <button v-on:click="scoreRepo" class="btn btn-primary">Submit</button>
    </div>
</template>

<script>

    import Vue from "vue";
    import $http from "../http-client";

    export default Vue.extend({
        data() {
            return {
                repositoryName: "",
            };
        },

        methods: {
            scoreRepo: function () {
                if (this.repositoryName === "") {
                    alert("Repository can not be null");
                } else {
                    const url = '/repo/score/' + this.repositoryName;
                    $http.post(url)
                        .then(resp => {
                            alert("Scoring repository is ok");
                            this.repositoryName = "";
                        }).catch((err) => {
                        alert("Problem occured");
                        this.repositoryName = "";
                    });
                }
            }
        }
    })
</script>