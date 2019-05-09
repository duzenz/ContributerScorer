<template>
    <div>
        <h3>Account Detail</h3>
        <table class="table">
            <tbody>
            <tr>
                <th scope="row">Account ID:</th>
                <td>{{account.id}}</td>
            </tr>
            <tr>
                <th scope="row">Login Name:</th>
                <td>{{account.login}}</td>
            </tr>
            <tr>
                <th scope="row">Url:</th>
                <td>{{account.html_url}}</td>
            </tr>
            <tr>
                <th scope="row">User Name:</th>
                <td>{{account.name}}</td>
            </tr>
            <tr>
                <th scope="row">Location:</th>
                <td>{{account.location}}</td>
            </tr>
            <tr>
                <th scope="row">Email:</th>
                <td>{{account.email}}</td>
            </tr>
            <tr>
                <th scope="row">Public Repo Count:</th>
                <td>{{account.public_repos}}</td>
            </tr>
            <tr>
                <th scope="row">Follower Count:</th>
                <td>{{account.followers}}</td>
            </tr>
            <tr>
                <th scope="row">Following Count:</th>
                <td>{{account.following}}</td>
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
                account: {},
            }
        },

        created: function () {
            this.fetchData();
        },

        methods: {
            fetchData: function () {
                $http.get('/account/' + this.$route.params.id)
                    .then(resp => {
                        this.account = resp.data;
                    })
            }
        }
    })


</script>