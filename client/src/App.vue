<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd; margin-bottom:20px">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="'retrieve'">
                            Retrieve Repo
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="'score'">
                            Score Repo
                        </router-link>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="app">
            <router-view/>
        </div>
    </div>
</template>