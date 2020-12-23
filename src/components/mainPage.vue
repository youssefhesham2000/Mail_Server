 <template>
  <v-app>
    <nav >
      <v-toolbar flat app> </v-toolbar>
      <v-navigation-drawer app v-model="drawer" dark>
        <br />
        <br />

        <h1 style="margin-left:30px; color: white;">
          name dddd
        </h1>
        <br />
        <v-btn
          depressed
          style=" width:300px; padding-right:90px"
          dark
          @click="$router.push('/compose')"
          >Compose</v-btn
        >
        <br />
        <v-btn
          depressed
          dark
          style=" width:300px; padding-right:80px"
          @click="$router.push('/Folder')"
          >New Folder</v-btn
        >
        <br />
        <v-btn
          depressed
          dark
          style=" width:300px; padding-right:90px"
          @click="$router.push('/Contacts')"
          >Contacts</v-btn
        >
        <br />
        <v-btn
          depressed
          dark
          style=" width:300px; padding-right:80px"
          @click="$router.push('/EmailModification')"
          >Email Modification</v-btn
        >
        <br />
        <v-btn
          depressed
          dark
          style=" width:300px; padding-right:80px"
          @click="$router.push(getUrl2())"
          >Folders Modification</v-btn
        >
        <v-list dense>
          <v-subheader>Folders</v-subheader>
          <v-list-item-group v-model="selectedItem" color="primary">
            <v-list-item v-for="(link, i) in links" :key="i">
              <v-list-item-icon>
                <v-icon>mdi-folder</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title
                  v-text="link.text"
                  @click="$router.push(findLink(link))"
                ></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>

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
     export default {
  name: "mainPage",

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
     }
</script>
<style scoped>
.link {
  text-decoration: none;
  background-color : grey darken-4;
  color: white;
  text-decoration-style: wavy;
  font-size: large;
}
.compose {
  width: 200px;
  margin-top: 10px;
}
</style>
