<template>
  <v-app>
    <!-- <HelloWorld />
    <router-link to="/try">hey </router-link>
    <router-view></router-view> -->
    <v-container v-if="signin & !ok">
      <v-card dark class="card">
        <br />
        <br />

        <v-text-field label="email"></v-text-field>
        <br />
        <v-text-field type="password" label="password"></v-text-field>
        <br />
        <br />
        <v-btn
          white
          class="btt"
          style="color:black; background-color:white; margin-left:20px"
        >
          sign in</v-btn
        >

        <v-btn @click="toggle()"> sign up instead</v-btn>
      </v-card>
    </v-container>
    
    <v-container v-if="!signin & !ok">
      <v-card dark class="card">
        <br />
        <br />
        <v-text-field label=" first name"></v-text-field>
        <br />
          <v-text-field label="last name"></v-text-field>
           
        <v-text-field label="email"></v-text-field>
        <br />
        <v-text-field type="password" label="password"></v-text-field>
        <br />
        <br />
        <v-btn
          style="color:black; background-color:white; margin-left:20px"
          class="btt"
        >
          sign up</v-btn
        >
        <v-btn @click="toggle()"> sign in instead</v-btn>
      </v-card>
    </v-container>

  
  </v-app>
</template>

<script>
// import HelloWorld from "./components/HelloWorld";

export default {
  name: "App",

  components: {
    // HelloWorld,
  },

  data: () => ({
    userName: "salah",
    selectedItem: -1,
    signin: false,
    ok: false,
    links: [
      {
        icon: "DashBoard",
        text: "DashBoard",
        route: "/",
      },
      { icon: "email", text: "My Projects", route: "/email" },
      { icon: "person", text: "table", route: "/table/ahmed/sent" },
    ],
    //
  }),
  methods: {
    getUrl2() {
      return "/folders/" + this.userName;
    },
    toggle() {
      this.signin = !this.signin;
    },
    findLink(value) {
      return value.route;
    },
    getIcon(value) {
      if (value != "f") {
        return "mdi - folder";
      }
      return "mdi - folder";
    },
  },
};
</script>
<style scoped>
.card {
  width: 500px;
  height: 500px;
  margin: auto;
  margin-top: 200px;
  padding: 40px;
}
.btt {
  margin-right: 100px;
}
.link {
  text-decoration: none;
  background-color: grey darken-4;
  color: white;
  text-decoration-style: wavy;
  font-size: large;
}
.compose {
  width: 200px;
  margin-top: 10px;
}
</style>
