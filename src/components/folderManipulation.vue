<template>
  <div class="email">
    <!-- <v-card hover> -->
    <v-card hover style="width:400px">
      <v-list flat>
        <v-subheader>FOLDERS</v-subheader>
        <v-list-item-group v-model="selectedItem" color="primary">
          <v-list-item v-for="(item, i) in items" :key="i">
            <v-list-item-content>
              <v-list-item-title v-text="item.name"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>

      <br />
      <v-text-field
        label="new folder or rename"
        style="width:250px; margin-left:20px;"
        v-model="text"
      ></v-text-field>

      <v-btn class="b" color="orange lighten-2" text @click="add()">
        add
      </v-btn>
      <v-btn class="b" color="orange lighten-2" text @click="rename()">
        rename
      </v-btn>
      <v-btn class="b" color="orange lighten-2" text @click="del()">
        delete
      </v-btn>
    </v-card>
    <!-- </v-card> -->
  </div>
</template>

<script>
export default {
  name: "folderManipulation",
  props: [],
  components: {},
  methods: {
    del() {
      var index = this.selectedItem;
      this.items.splice(index, 1);
    },
    rename() {
      var index = this.selectedItem;
      var name = this.text;
      if (name != "" && index != -1) {
        this.items[index].name = name;
      }
    },
    add() {
      var x = { name: "" };
      x.name = this.text;
      this.items.push(x);
    },
  },
  mounted() {
    console.log(this.selectedEmail);
  },

  data: () => ({
    text: "",
    selectedItem: -1,
    mail: null,
    items: [{ name: "inbox" }, { name: "sent" }, { name: "trash" }],
    //
  }),
};
</script>
<style scoped>
.email {
  margin-top: 50px;
  margin-left: 300px;
  padding-left: 40px;
  width: 900px;
}
.b {
  margin-left: 50px;
  margin-inline: 2px;
}
</style>
