<template>
  <div class="tab">
    <v-card elevation="2" outlined tile>
      <v-card-title>{{ folder }}</v-card-title>

      <v-card-text>
        <v-chip-group
          v-model="selection"
          active-class="deep-purple accent-4 white--text"
          column
        >
          <v-chip large>sort</v-chip>

          <v-chip large>search</v-chip>

          <v-chip large>filter</v-chip>
          <v-chip large>move</v-chip>
        </v-chip-group>
      </v-card-text>
      <v-card>
        <div v-if="selection == 1">
          <div class="text-center">
            <v-text-field class="textf"></v-text-field>
            <v-btn class="b" color="orange lighten-2" text>
              Search
            </v-btn>
            <v-menu open-on-hover top offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn dark v-bind="attrs" v-on="on">
                  {{ searchType }}
                </v-btn>
              </template>

              <v-list>
                <v-list-item
                  v-for="(item, index) in items"
                  :key="index"
                  @click="menue(item.title)"
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </div>
          <br />
          <br />
        </div>
        <div v-if="selection == 0">
          <div class="text-center">
            <br />
            <v-btn class="b" color="orange lighten-2" text>
              Sort
            </v-btn>
            <v-menu open-on-hover top offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn dark v-bind="attrs" v-on="on">
                  {{ sortType }}
                </v-btn>
              </template>

              <v-list>
                <v-list-item
                  v-for="(item, index) in items2"
                  :key="index"
                  @click="menue2(item.title)"
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </div>
          <br />
          <br />
        </div>

        <div v-if="selection == 3">
          <div class="text-center">
            <br />
            <h2>Select emails to move :</h2>
            <v-btn class="b" color="orange lighten-2" text>
              Move
            </v-btn>
            <v-menu open-on-hover top offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn dark v-bind="attrs" v-on="on">
                  {{ moveFolder }}
                </v-btn>
              </template>

              <v-list>
                <v-list-item
                  v-for="(item, index) in items3"
                  :key="index"
                  @click="menue3(item.title)"
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </div>
          <br />
          <br />
        </div>
      </v-card>
    </v-card>

    <v-data-table
      v-model="selected"
      :headers="headers"
      :items="desserts"
      :single-select="singleSelect"
      item-key="name"
      show-select
      class="elevation-1"
    >
      <template v-slot:top>
        <v-switch
          v-model="singleSelect"
          label="Single select"
          class="pa-3"
        ></v-switch>
        <!-- <v-btn> -->

        <v-btn depressed white class="open" @click="$router.push('/email/dfr')"
          >open</v-btn
        >
        <!-- </v-btn> -->
        <v-btn depressed white class="open">Delete</v-btn>

        <br />
      </template>
    </v-data-table>
  </div>
</template>
<script>
export default {
  props: ["name", "userfolder"],
  mounted() {
    console.log(this.name);
    console.log(this.userfolder);
  },
  methods: {
    menue(value) {
      this.searchType = value;
    },
    menue2(value) {
      this.sortType = value;
    },
    menue3(value) {
      this.sortType = value;
    },
  },
  data() {
    return {
      moveFolder: "inbox",
      sortType: "date",
      searchType: "subject",
      items: [
        { title: "subject" },
        { title: "date" },
        { title: "sender" },
        { title: "reciever" },
      ],
      items2: [
        { title: "subject",value:2 },
        { title: "date" ,value:5 },
        { title: "sender",value:3 },
        { title: "reciever" ,value:4},
        
      ],
      items3: [{ title: "inbox" }, { title: "sent" }, { title: "trash" }],
      folder: "Inbox",
      selection: -1,
      singleSelect: false,
      selected: [],
      headers: [
        {
          text: "Dessert (100g serving)",
          align: "start",
          sortable: false,
          value: "name",
        },
        { text: "Calories", value: "calories", sortable: false },
        { text: "Fat (g)", value: "fat", sortable: false },
        { text: "Carbs (g)", value: "carbs", sortable: false },
        { text: "Protein (g)", value: "protein", sortable: false },
        { text: "Iron (%)", value: "iron", sortable: false },
      ],
      desserts: [
        {
          name: "Frozen Yogurt",
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: "1%",
        },
        {
          name: "Ice cream sandwich",
          calories: 237,
          fat: 9.0,
          carbs: 37,
          protein: 4.3,
          iron: "1%",
        },
        {
          name: "Eclair",
          calories: 262,
          fat: 16.0,
          carbs: 23,
          protein: 6.0,
          iron: "7%",
        },
        {
          name: "Cupcake",
          calories: 305,
          fat: 3.7,
          carbs: 67,
          protein: 4.3,
          iron: "8%",
        },
        {
          name: "Gingerbread",
          calories: 356,
          fat: 16.0,
          carbs: 49,
          protein: 3.9,
          iron: "16%",
        },
        {
          name: "Jelly bean",
          calories: 375,
          fat: 0.0,
          carbs: 94,
          protein: 0.0,
          iron: "0%",
        },
        {
          name: "Lollipop",
          calories: 392,
          fat: 0.2,
          carbs: 98,
          protein: 0,
          iron: "2%",
        },
        {
          name: "Honeycomb",
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          iron: "45%",
        },
        {
          name: "Donut",
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          iron: "22%",
        },
        {
          name: "KitKat",
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          iron: "6%",
        },
      ],
    };
  },
};
</script>
<style scoped>
.tab {
  margin-left: 200px;
}
.textf {
  margin-left: 50px;
  margin-right: 50px;
}
.b {
  margin-left: 50px;
  margin-inline: 2px;
}
.open {
  margin-left: 20px;
  width: 200px;
  background-color: darkgray;
}
</style>
