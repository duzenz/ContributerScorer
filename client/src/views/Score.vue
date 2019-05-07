<template>
    <div>
        <form v-on:submit="sub" action="#" method="post">
            <div class="form-group">
                <label for="repositoryName">Repository Name</label>
                <input type="text" class="form-control" id="repositoryName" v-model="repositoryName" placeholder="Repository Name">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</template>