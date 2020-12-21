<template>
    <v-app>
    
    <v-container v-if="signin & !ok">
      <v-card class="card">
        <br />
        <br />

        <v-text-field label="email"></v-text-field>
        <br />
        <v-text-field type="password" label="password"></v-text-field>
        <br />
        <br />
        <v-btn class="btt"> sign in</v-btn>

        <v-btn @click="toggle()"> sign up instead</v-btn>
      </v-card>
    </v-container>

    <v-container v-if="!signin & !ok">
      <v-card class="card">
        <br />
        <br />
        <v-text-field label="name"></v-text-field>
        <br />
        <v-text-field label="email"></v-text-field>
        <br />
        <v-text-field type="password" label="password"></v-text-field>
        <br />
        <br />
        <v-btn class="btt"> sign up</v-btn>
        <v-btn @click="toggle()"> sign in instead</v-btn>
      </v-card>
    </v-container>
    <nav v-if="ok">
      <v-toolbar flat app> </v-toolbar>

      <v-navigation-drawer app v-model="drawer" dark class="primary">
        <br />
        <br />
        <br />
        <v-btn>
          <router-link to="/compose" class="link">compose </router-link>
        </v-btn>
        <ul>
          <v-btn v-for="link in links" :key="link.text">
            <router-link :to="link.route" class="link"
              >{{ link.text }}
            </router-link>
          </v-btn>
        </ul>
         <v-btn>
          <router-link to="/EmailModification" class="link">E-Mail Modification </router-link>
        </v-btn>
        <v-btn>
          <router-link to="/Contacts" class="link">Contacts </router-link>
        </v-btn>

        <br />
        <br />
        <br />
      </v-navigation-drawer>
      <v-container>
        <router-view></router-view>
      </v-container>
    </nav>
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
    signin: true,
    ok: true,
    links: [
      { icon: "dashboard", text: "Dashboard", route: "/" },
      { icon: "email", text: "My Projects", route: "/play" },
      { icon: "person", text: "table", route: "/table" },
    ],
    //
  }),
  methods: {
    toggle() {
      this.signin = !this.signin;
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
</style>
