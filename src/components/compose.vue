<template>
  <div class="tab">
    <v-container class="sender">
      <v-chip
        close-icon="mdi-close-outline"
        color="purple"
        label
        x-large
        outlined
        >sender</v-chip
      >
      <v-menu top :close-on-content-click="closeOnContentClick">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            depressed
            elevation="10"
            outlined
            rounded
            x-large
            v-bind="attrs"
            v-on="on"
          >
            Choose E-Mail
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(item, index) in EMAil" :key="index">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-container>

    <v-container>
      <v-text-field label=" Reciever E-Mail"></v-text-field>
      <v-btn depressed elevation="10" outlined rounded x-large
        >Add Reciever</v-btn
      >
      <v-menu>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            depressed
            elevation="10"
            outlined
            rounded
            x-large
            v-bind="attrs"
            v-on="on"
          >
            choose from contacts
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(item, index) in EMAil" :key="index">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-container>
    <!-- <v-container>
        <v-chip color="blue" label outlined x-large>Attachments</v-chip>
        <v-btn
          depressed
          elevation="10"
          outlined
          rounded
          x-large
          v-bind="attrs"
          v-on="on"
        >
          choose Attachments
        </v-btn>
      </v-container> -->
    <v-container>
      <v-text-field label=" Subject"></v-text-field>
    </v-container>
    <v-container>
      <v-textarea autocomplete="email" label="Email"></v-textarea>
    </v-container>

    <form ref="uploadForm" @submit.prevent="submit">
      <input
        type="file"
        ref="uploadFile"
        @change="onUpload()"
        class="form-control"
        required
      />
      <v-btn @click="up()">upload</v-btn>
    </form>

    <v-btn
      class="b"
      color="orange lighten-2"
      text
      @click="del()"
      v-if="items.length > 0"
    >
      delete
    </v-btn>

    <v-card hover style="width:400px" v-if="items.length > 0">
      <v-list flat>
        <v-list-item-group v-model="selectedItem" color="primary">
          <v-list-item v-for="(item, i) in items" :key="i">
            <v-list-item-content>
              <v-list-item-title v-text="item.name"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
    <br />
    <v-container>
      <v-btn depressed elevation="10" outlined rounded x-large> Send</v-btn>
      <v-btn depressed elevation="10" outlined rounded x-large>
        Save as a draft</v-btn
      >
      <v-btn depressed elevation="10" outlined rounded x-large>
        LOad draft</v-btn
      >
    </v-container>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "compose",

  components: {},

  data: () => ({
    port: "http://localhost:8089",

    fileName: "",
    selectedItem: -1,
    formdata: null,
    items: [],
    att: [],
    EMAil: [],
    //
  }),
  methods: {
    del() {
      var index = this.selectedItem;
      this.items.splice(index, 1);
      // var ranNam = this.att[index];
      this.att.splice(index, 1);
      // axios({
      //   url: this.port + "/deleteAttachment/"+ranNam,
      //   method: "DELETE",
      // }).then((r) => {
      //   console.log(r);
      // });
    },

    add() {
      var x = { name: "" };
      x.name = this.text;
      this.items.push(x);
    },
    onUpload() {
      let file = this.$refs.uploadFile.files[0];
      this.fileName = file.name;
      this.formdata = new FormData();
      this.formdata.append("file", file);
    },
    up() {
      var x = { name: "" };
      x.name = this.fileName;
      this.items.push(x);
      var r = Math.floor(Math.random() * 100000000000);
      var ranName = "" + r + "_" + this.fileName;
      this.att.push(ranName);

      // axios({
      //   url: "http://localhost:8089/upload",
      //   method: "POST",
      //   data: this.formdata,
      //   headers: {
      //     Accept: "application/json",
      //     "Content-Type": "multipart/form-data",
      //   },
      // }).then(() => {
      //   console.log("ok");
      // });
    },
  },
};
</script>
<style scoped>
.sender {
  align-self: center;
  margin-left: 20%;
}
.table {
  margin-left: 400px;
  padding-left: 40px;
}
.tab {
  margin-left: 200px;
}
</style>
