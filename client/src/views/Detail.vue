<template>
    <ol>
        <li v-for="(record, index) in recordList" :key="index">
            {{record.userId}}
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
                $http.get('/contributor/' + this.$route.params.id)
                    .then(resp => {
                        this.recordList = resp.data;
                    })
            }
        }
    })


</script>