<template>
  <div class="email">
    <v-card hover>
      <v-card-text>
        <p class="body-1">subject:</p>
        <p class="display-2 text--primary">
          el·ee·mos·y·nar·y
        </p>
        <p class="body-1">sender:</p>
        <p class="subtitle-2 text--primary">
          el·ee·mos·y·nar·y
        </p>
        <p class="body-1">recievers:</p>
        <p class="subtitle-2 text--primary">
          el·ee·mos·y·nar·y
        </p>

        <p class="body-1">body:</p>
        <div class="display-1 text--primary">
          relating to or dependent on charity; charitable.<br />
          "an eleemosynary educational institution."
        </div>
        <br />
        <p class="body-1">attatchments:</p>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "email",
  props: ["selectedEmail"],
  components: {},
  mounted() {
    console.log(this.selectedEmail);
  },

  data: () => ({
    mail: null,
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
</style>
